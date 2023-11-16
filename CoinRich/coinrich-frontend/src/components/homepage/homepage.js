import React from "react"
import "./homepage.css"
import { useNavigate } from "react-router-dom"
import CryptoData from "../cryptoData/CryptoData";

const Homepage = ({}) => {

    let navigate = useNavigate();

    return (
        <div className="homepage">
            <h1>Hello Homepage</h1>
            <div className="button" onClick={() => { navigate("/login")}} >Logout</div>
            <CryptoData />
        </div>
    )
}

export default Homepage