import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FaArrowUp, FaArrowDown } from 'react-icons/fa';
import './CryptoData.css'

const CryptoData = () => {
  const [cryptoData, setCryptoData] = useState([]);

  useEffect(() => {
    
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8086/api/v1/user/getdata',{headers : {
          'api-key': 'some_very_complex_string'
      }});
        console.log(response);
        setCryptoData(typeof response.data.data); // Assuming the response is an array of crypto data
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    
       <div className="crypto-container">
        {}
        {cryptoData.map((crypto) => (
        <div key={crypto.id} className="crypto-item">
          <div className="crypto-rank">Rank: {crypto.data.data.ADA}</div>
          <div className="crypto-symbol">Symbol: {crypto.symbol}</div>
          <div className="crypto-price">Price (USD): {crypto.quote.usd.price_usd}</div>
          <div className="crypto-change">
            24hr Change: {crypto.quote.usd.percent_change_24h > 0 ? <FaArrowUp /> : <FaArrowDown />}
            {crypto.quote.usd.percent_change_24h}%
          </div>
        </div>
      ))}
    </div>
     
  
  )
};

export default CryptoData;