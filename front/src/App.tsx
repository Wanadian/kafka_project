import './App.css'
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Simulate} from "react-dom/test-utils";

type GlobalType = {
    id: string;
    newConfirmed: number;
    totalConfirmed: number;
    newDeaths: number;
    totalDeaths: number;
    newRecovered: number;
    totalRecovered: number;
    date: number;
}

type CountryType = {
    id: string;
    newConfirmed: number;
    totalConfirmed: number;
    newDeaths: number;
    totalDeaths: number;
    newRecovered: number;
    totalRecovered: number;
    date: number;
}

function App() {
    const [globalValue, setGlobalValue] = useState<GlobalType>({id: "id", newConfirmed: 0, totalConfirmed: 0, newDeaths: 0, totalDeaths: 0, newRecovered: 0, totalRecovered: 0, date: 0});
    const [countryValue, setCountryValue] = useState<CountryType>({id: "id", newConfirmed: 0, totalConfirmed: 0, newDeaths: 0, totalDeaths: 0, newRecovered: 0, totalRecovered: 0, date: 0});
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
              <div>new confirmed : {globalValue.newConfirmed}</div>
              <div>total confirmed : {globalValue.totalConfirmed}</div>
              <div>new deaths : {globalValue.newDeaths}</div>
              <div>total deaths : {globalValue.totalDeaths}</div>
              <div>new recovered : {globalValue.newRecovered}</div>
              <div>total recovered : {globalValue.totalRecovered}</div>
          </span>
          <span className="container">
              <form>
                  <select name="Country" id="country" className="selector">
                      <option value="canada">Canada</option>
                      <option value="france">France</option>
                  </select>
                  <h1 className="title">Values</h1>
                  <div>new confirmed : {countryValue.newConfirmed}</div>
                  <div>total confirmed : {countryValue.totalConfirmed}</div>
                  <div>new deaths : {countryValue.newDeaths}</div>
                  <div>total deaths : {countryValue.totalDeaths}</div>
                  <div>new recovered : {countryValue.newRecovered}</div>
                  <div>total recovered : {countryValue.totalRecovered}</div>
                  <button type="submit">Get values</button>
              </form>
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
