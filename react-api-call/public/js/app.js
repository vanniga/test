'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var App = function (_React$Component) {
  _inherits(App, _React$Component);

  function App(props) {
    _classCallCheck(this, App);

    var _this = _possibleConstructorReturn(this, (App.__proto__ || Object.getPrototypeOf(App)).call(this, props));

    _this.state = {
      cardList: [],
      fullName: '',
      cardNumber: '',
      balance: '',
      limit: '',
      currency: ''
    };

    _this.create = _this.create.bind(_this);
    _this.handleChange = _this.handleChange.bind(_this);
    return _this;
  }

  _createClass(App, [{
    key: 'componentDidMount',
    value: function componentDidMount() {
      var _this2 = this;

      // get all entities - GET
      var options = {
        method: 'GET',
        headers: {
          'Host': 'localhost',
          'RequestID': '009692ee-f930-4a74-bbd0-63b8baa5a927',
          'OriginatorID': 'local',
          'AppID': 'Client1',
          'Accept': 'application/json',
          "content-type": "application/json"
        }
      };

      fetch('http://localhost:8081/uk/msa/v1/payment/creditcard', options).then(function (response) {
        return response.json();
      }).then(function (response) {
        _this2.setState({
          cardList: response
        });
      }).catch(function (err) {
        return console.error(err);
      });
    }
  }, {
    key: 'create',
    value: function create(e) {
      // add entity - POST
      e.preventDefault();

      // creates entity
      fetch("http://localhost:8081/uk/msa/v1/payment/creditcard", {
        "method": "POST",
        "headers": {
          'Host': 'localhost',
          "RequestID": "009692ee-f930-4a74-bbd0-63b8baa5a927",
          "OriginatorID": "local",
          "AppID": "Client1",
          "Accept": "application/json",
          "content-type": "application/json"
        },
        "body": JSON.stringify({
          fullName: this.state.fullName,
          cardNumber: this.state.cardNumber,
          balance: this.state.balance,
          limit: this.state.limit,
          currency: this.state.currency
        })
      }).then(function (response) {
        return response.json();
      }).then(function (response) {
        console.log(response);
      }).catch(function (err) {
        console.log(err);
      });
    }
  }, {
    key: 'handleChange',
    value: function handleChange(changeObject) {
      this.setState(changeObject);
    }
  }, {
    key: 'render',
    value: function render() {
      var _this3 = this;

      return React.createElement(
        'div',
        { className: 'container' },
        React.createElement(
          'div',
          { className: 'row justify-content-center' },
          React.createElement(
            'div',
            { className: 'col-md-8' },
            React.createElement(
              'h1',
              { className: 'display-4 text-center' },
              'Credit Card System'
            ),
            React.createElement(
              'form',
              { className: 'd-flex flex-column' },
              React.createElement(
                'legend',
                { className: 'text-center' },
                'Add Credit Card details'
              ),
              React.createElement(
                'label',
                { htmlFor: 'fullName' },
                'Full Name:',
                React.createElement('input', {
                  name: 'fullName',
                  id: 'fullName',
                  type: 'text',
                  className: 'form-control',
                  value: this.state.fullName,
                  onChange: function onChange(e) {
                    return _this3.handleChange({ fullName: e.target.value });
                  },
                  required: true
                })
              ),
              React.createElement(
                'label',
                { htmlFor: 'cardNumber' },
                'Card Number:',
                React.createElement('input', {
                  name: 'cardNumber',
                  id: 'cardNumber',
                  type: 'text',
                  className: 'form-control',
                  value: this.state.cardNumber,
                  onChange: function onChange(e) {
                    return _this3.handleChange({ cardNumber: e.target.value });
                  },
                  required: true
                })
              ),
              React.createElement(
                'label',
                { htmlFor: 'balance' },
                'Balance:',
                React.createElement('input', {
                  name: 'balance',
                  id: 'balance',
                  type: 'text',
                  className: 'form-control',
                  value: this.state.balance,
                  onChange: function onChange(e) {
                    return _this3.handleChange({ balance: e.target.value });
                  }
                })
              ),
              React.createElement(
                'label',
                { htmlFor: 'limit' },
                'Limit:',
                React.createElement('input', {
                  name: 'limit',
                  id: 'limit',
                  type: 'text',
                  className: 'form-control',
                  value: this.state.limit,
                  onChange: function onChange(e) {
                    return _this3.handleChange({ limit: e.target.value });
                  }
                })
              ),
              React.createElement(
                'label',
                { htmlFor: 'currency' },
                'Currency:',
                React.createElement('input', {
                  name: 'currency',
                  id: 'currency',
                  type: 'text',
                  className: 'form-control',
                  value: this.state.currency,
                  onChange: function onChange(e) {
                    return _this3.handleChange({ currency: e.target.value });
                  }
                })
              ),
              React.createElement(
                'button',
                { className: 'btn btn-primary', type: 'button', onClick: function onClick(e) {
                    return _this3.create(e);
                  } },
                'Add'
              )
            ),
            React.createElement(CardList, { cardList: this.state.cardList })
          )
        )
      );
    }
  }]);

  return App;
}(React.Component);

'use strict';

var CardList = function (_React$Component2) {
  _inherits(CardList, _React$Component2);

  function CardList() {
    _classCallCheck(this, CardList);

    return _possibleConstructorReturn(this, (CardList.__proto__ || Object.getPrototypeOf(CardList)).apply(this, arguments));
  }

  _createClass(CardList, [{
    key: 'render',
    value: function render() {
      return React.createElement(
        'table',
        null,
        React.createElement(
          'thead',
          null,
          React.createElement(
            'tr',
            null,
            React.createElement(
              'th',
              null,
              'Full Name'
            ),
            React.createElement(
              'th',
              null,
              'Card Number'
            ),
            React.createElement(
              'th',
              null,
              'Balance'
            ),
            React.createElement(
              'th',
              null,
              'Limit'
            ),
            React.createElement(
              'th',
              null,
              'Currency'
            )
          )
        ),
        React.createElement(
          'tbody',
          null,
          this.props.cardList && this.props.cardList.map(function (cards) {
            return React.createElement(
              'tr',
              null,
              React.createElement(
                'td',
                null,
                cards.fullName
              ),
              React.createElement(
                'td',
                null,
                cards.cardNumber
              ),
              React.createElement(
                'td',
                null,
                cards.balance
              ),
              React.createElement(
                'td',
                null,
                cards.limit
              ),
              React.createElement(
                'td',
                null,
                cards.currency
              )
            );
          })
        )
      );
    }
  }]);

  return CardList;
}(React.Component);

// App component

var domContainer = document.querySelector('#App');
ReactDOM.render(React.createElement(App, null), domContainer);