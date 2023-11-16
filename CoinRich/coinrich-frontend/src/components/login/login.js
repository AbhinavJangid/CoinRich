import React, { useState } from "react"
import "./login.css"
import axios from "axios"
import { useNavigate } from "react-router-dom"
import { useAuth } from "../../context/AuthContext"

const Login = ({ setLoginUser }) => {


    const {authUser, setAuthUser, isLoggedIn, setIsLoggedIn} = useAuth()

    const navigate = useNavigate()

    const [user, setUser] = useState({
        email: "",
        password: ""
    })

    const handleChange = e => {
        const { name, value } = e.target
        setUser({
            ...user,
            [name]: value
        })
    }

    const login = (e) => {
        axios.post("http://localhost:8086/api/v1/user/login", user, {headers : {
            'api-key': 'some_very_complex_string'
        }})
            .then(res => {
                console.log(res.data)

                if (res.data.response == true) {
                    e.preventDefault()
                    setIsLoggedIn(true)
                    setAuthUser({
                        Name : res.data.name,
                        Email : res.data.email
                    })
                    navigate("/home")
                } else {
                    alert(res.data.message)
                }

            }).catch((err) => {
                if (err.response) {
                    console.log(err.response.status)
                }
            });
    }

    return (
        <div className="login">
            <h1>Login</h1>
            <input type="text" name="email" value={user.email} onChange={handleChange} placeholder="Enter your Email"></input>
            <input type="password" name="password" value={user.password} onChange={handleChange} placeholder="Enter your Password" ></input>
            <div className="button" onClick={(e)=>{login(e)}}>Login</div>
            <div>or</div>
            <div className="button" onClick={() => navigate("/register")}>Register</div>
        </div>
    )
}

export default Login