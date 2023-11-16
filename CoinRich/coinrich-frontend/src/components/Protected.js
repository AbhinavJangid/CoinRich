import React from 'react'

export default function Protected(props) {


    const {Component} = props

    
  return (
    <div>
        <Component />
    </div>
  )
}
