# currencyExchanger
The user has a multi-currency account with starting balance of **1000 Euros (EUR)**. They can convert any currency to any if the rate is provided by the API but the balance can't fall below zero. Created **an input** where the user will enter amount, **picker** for currency being **sold** and a **picker** for currency being **bought**. 

For example, user inputs **100.00**, picks **Euros** to sell and **Dollars** to buy. User then clicks **Submit** button, a message is shown `You have converted 100.00 EUR to 110.30 USD` and now the balance is **900.00 Euros** and **110.30 US Dollars**. 

## Currency Exchange Rate API

- The API is public and no authentication is required
- Currency exchange rates should be synchronized **every 5 seconds**

**URI**: `https://api.exchangeratesapi.io/latest`

**Response example**:

```
{
  "rates": {
    "JPY": 118.52,
    "USD": 1.103,
    "GBP": 0.90155
  },
  "base": "EUR",
  "date": "2019-10-10"
}
```

![alt text](https://i.imgur.com/XGlpCR9.png "Exchanger")
