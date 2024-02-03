import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PaymentForm = ({ onPayment }) => {

  const [name, setName] = useState('');
  const [cardNumber, setCardNumber] = useState('');
  const [expDate, setExpDate] = useState('');
  const [cvv, setCvv] = useState('');
  const [amount, setAmount] = useState('');
  const [savedCards, setSavedCards] = useState([]);

  useEffect(() => {
    fetch(`/card/makePayment`, 
    {
      method: 'GET',
      headers: {
        'Content-type': 'application/json',
      },
    })
    .then((result) => result.json())
    .then((json) => {setSavedCards(json.data);});
  }, []);

  const handlePayment = () => {
    const paymentData = {
      name,
      cardNumber,
      expDate,
      cvv,
      amount,
    };

    onPayment(paymentData);
  };

  return (
    <div className={`${styles.main}`}>
      <form>
        <label>
          Name:
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </label>
        <br />
        <label>
          Card Number:
          <input type="text" value={cardNumber} onChange={(e) => setCardNumber(e.target.value)} />
        </label>
        <br />
        <label>
          Expiration Date:
          <input type="text" value={expDate} onChange={(e) => setExpDate(e.target.value)} />
        </label>
        <br />
        <label>
          CVV:
          <input type="text" value={cvv} onChange={(e) => setCvv(e.target.value)} />
        </label>
        <br />
        <label>
          Amount:
          <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)} />
        </label>
        <br />
        <button type="button" onClick={handlePayment}>
          Make Payment
        </button>
      </form>
    </div>
  );
};

export default PaymentForm;