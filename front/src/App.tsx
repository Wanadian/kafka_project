import './App.css'
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Simulate} from "react-dom/test-utils";
import load = Simulate.load;
import error = Simulate.error;

function App() {
    const [globalValues, setGlobalValue] = useState(undefined);
    const [countryValue, setCountryValue] = useState(undefined);
    const [confirmedAverageValue, setConfirmedAverageValue] = useState(undefined);
    const [deathAverageValue, setDeathAverageValue] = useState(undefined);
    const [lethalityValue, setLethalityValue] = useState(undefined);

    useEffect( () => {
        axios.get("http://localhost:8078/global")
            .then((response) => {
            setGlobalValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
        });
    }, [])
    function getCountryValues (countryName : string) {
        axios.get("http://localhost:8078/countries/" + countryName)
            .then((response) => {
            setCountryValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
            });
    }
    useEffect( () => {
        axios.get("http://localhost:8078/countries/confirmed_avg")
            .then((response) => {
            setConfirmedAverageValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
            });
    }, [])
    useEffect( () => {
        axios.get("http://localhost:8078/countries/deaths_avg")
            .then((response) => {
            setDeathAverageValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
            });
    }, [])
    useEffect( () => {
        axios.get("http://localhost:8078/countries/lethality")
            .then((response) => {
            setLethalityValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
            });
    }, [])


  return (
      <div className="information-dashboard">
          <span className="container">
            <h1 className="title">Global values</h1>
            <div>{globalValues}</div>
          </span>
          <span className="container">
              <form>
                  <select name="Country" id="country" className="selector">
                      <option value="canada" selected>Canada</option>
                      <option value="france">France</option>
                  </select>
                  <h1 className="title">Values</h1>
                  <button type="submit">Get values</button>
              </form>

            <div>{countryValue}</div>
          </span>
          <span className="container">
            <h1 className="title">Confirmed average value</h1>
            <div>{confirmedAverageValue}</div>
          </span>
          <span className="container">
            <h1 className="title">Death average value</h1>
            <div>{deathAverageValue}</div>
          </span>
          <span className="container">
            <h1 className="title">Lethality value</h1>
            <div>{lethalityValue}</div>
          </span>
      </div>
  )
}

export default App
