import './home.css'
import React, {useEffect, useState} from "react";
import axios from "axios";

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

function Home() {
    const [globalValue, setGlobalValue] = useState<GlobalType>({id: "id", newConfirmed: 0, totalConfirmed: 0, newDeaths: 0, totalDeaths: 0, newRecovered: 0, totalRecovered: 0, date: 0});
    const [countryValue, setCountryValue] = useState<CountryType>({id: "id", newConfirmed: 0, totalConfirmed: 0, newDeaths: 0, totalDeaths: 0, newRecovered: 0, totalRecovered: 0, date: 0});
    const [country, setCountry] = useState("Canada");
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
    useEffect(() => {
        axios.get("http://localhost:8078/countries/" + country)
            .then((response) => {
            setCountryValue(response.data);
        })
            .catch((error) =>{
                console.log(error)
            });
    }, [country])
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

    const handleChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setCountry(e.target.value);
    }


  return (
      <div className="information-dashboard">
          <span className="container">
            <div className="title">Global values</div>
              <div>New confirmed : {globalValue.newConfirmed} person(s)</div>
              <div>Total confirmed : {globalValue.totalConfirmed} person(s)</div>
              <div>New deaths : {globalValue.newDeaths} person(s)</div>
              <div>Total deaths : {globalValue.totalDeaths} person(s)</div>
              <div>New recovered : {globalValue.newRecovered} person(s)</div>
              <div>Total recovered : {globalValue.totalRecovered} person(s)</div>
          </span>
          <span className="container">
              <div className="title">Country Values</div>
              <select name="Country" id="country" value={country} onChange={handleChange} className="selector">
                  <option value="Canada">Canada</option>
                  <option value="France">France</option>
              </select>
              <div>New confirmed : {countryValue.newConfirmed} person(s)</div>
              <div>Total confirmed : {countryValue.totalConfirmed} person(s)</div>
              <div>New deaths : {countryValue.newDeaths} person(s)</div>
              <div>Total deaths : {countryValue.totalDeaths} person(s)</div>
              <div>New recovered : {countryValue.newRecovered} person(s)</div>
              <div>Total recovered : {countryValue.totalRecovered} person(s)</div>
         </span>
          <span className="container">
            <div className="title">Confirmed average value</div>
            <div>{confirmedAverageValue} person(s)</div>
          </span>
          <span className="container">
            <div className="title">Death average value</div>
            <div>{deathAverageValue} person(s)</div>
          </span>
          <span className="container">
            <div className="title">Lethality value</div>
            <div>{lethalityValue} %</div>
          </span>
      </div>
  )
}

export default Home
