import React, { useState, useEffect } from 'react';
import PaymentForm from './PaymentForm';
import axios from 'axios';

function App() {
  const [paymentStatus, setPaymentStatus] = useState(null);

  const handlePayment = () => {
    fetch(`/card/makePayment`, 
    {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      // body: {

      // }
    })
    .then(result => result.json());
  }

  return (
    <div>
      <h1>Online Payment System</h1>
      <PaymentForm onPayment={handlePayment} />
      {paymentStatus && <p>Status: {paymentStatus}</p>}
    </div>
  );
};

export default App;