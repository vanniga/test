'use strict';
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      cardList: [],
      fullName: '',
      cardNumber: '',
      balance: '',
      limit: '',
      currency: ''
    };

    this.create = this.create.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  componentDidMount() {
    // get all entities - GET
    const options = {
        method: 'GET',
        headers: {
            'Host':'localhost',
            'RequestID':'009692ee-f930-4a74-bbd0-63b8baa5a927',
            'OriginatorID':'local',
            'AppID':'Client1',
            'Accept':'application/json',
            "content-type": "application/json",
        }
    };
    
    fetch('http://localhost:8081/uk/msa/v1/payment/creditcard', options)
        .then(response => response.json())
        .then(response => {this.setState({
                     cardList: response
                   })
        }).catch(err => console.error(err));
  }

  create(e) {
    // add entity - POST
    e.preventDefault();

    // creates entity
fetch("http://localhost:8081/uk/msa/v1/payment/creditcard", {
    "method": "POST",
    "headers": {
        'Host':'localhost',
        "RequestID":"009692ee-f930-4a74-bbd0-63b8baa5a927",
        "OriginatorID":"local",
        "AppID":"Client1",
        "Accept":"application/json",
        "content-type": "application/json",
    },
    "body": JSON.stringify({
      fullName: this.state.fullName,
      cardNumber: this.state.cardNumber,
      balance: this.state.balance,
      limit: this.state.limit,
      currency: this.state.currency 
    })
  })
  .then(response => response.json())
  .then(response => {
    console.log(response)
  })
  .catch(err => {
    console.log(err);
  });
  }

  handleChange(changeObject) {
    this.setState(changeObject)
  }

  render() {
    return (
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-md-8">
              <h1 className="display-4 text-center">Credit Card System</h1>
              <form className="d-flex flex-column">
                <legend className="text-center">Add Credit Card details</legend>
                <label htmlFor="fullName">
                  Full Name:
                  <input
                    name="fullName"
                    id="fullName"
                    type="text"
                    className="form-control"
                    value={this.state.fullName}
                    onChange={(e) => this.handleChange({ fullName: e.target.value })}
                    required
                    />
                </label>
                <label htmlFor="cardNumber">
                  Card Number:
                  <input
                    name="cardNumber"
                    id="cardNumber"
                    type="text"
                    className="form-control"
                    value={this.state.cardNumber}
                    onChange={(e) => this.handleChange({ cardNumber: e.target.value })}
                    required
                    />
                </label>
                <label htmlFor="balance">
                  Balance:
                  <input
                    name="balance"
                    id="balance"
                    type="text"
                    className="form-control"
                    value={this.state.balance}
                    onChange={(e) => this.handleChange({ balance: e.target.value })}
                    />
                </label>
                <label htmlFor="limit">
                  Limit:
                  <input
                    name="limit"
                    id="limit"
                    type="text"
                    className="form-control"
                    value={this.state.limit}
                    onChange={(e) => this.handleChange({ limit: e.target.value })}
                    />
                </label>
                <label htmlFor="currency">
                  Currency:
                  <input
                    name="currency"
                    id="currency"
                    type="text"
                    className="form-control"
                    value={this.state.currency}
                    onChange={(e) => this.handleChange({ currency: e.target.value })}
                    />
                </label>
                <button className="btn btn-primary" type='button' onClick={(e) => this.create(e)}>
                  Add
                </button>
                
              </form>
              <CardList cardList={this.state.cardList} />
            </div>
          </div>
        </div>
    );
  }
}

'use strict';
class CardList extends React.Component {
    render() {
        return (
            <table>
                <thead>
                    <tr>
                        <th>Full Name</th>
                        <th>Card Number</th>
                        <th>Balance</th>
                        <th>Limit</th>
                        <th>Currency</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.cardList && this.props.cardList.map(cards => {
                        return <tr>
                            <td>{cards.fullName}</td>
                            <td>{cards.cardNumber}</td>
                            <td>{cards.balance}</td>
                            <td>{cards.limit}</td>
                            <td>{cards.currency}</td>
                        </tr>
                    })}
                </tbody>
            </table>
        );
    }
}

// App component

let domContainer = document.querySelector('#App');
ReactDOM.render(<App />, domContainer);