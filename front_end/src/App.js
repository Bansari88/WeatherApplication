import { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
} from "mdb-react-ui-kit";
import InputSection from './components/InputSection';
import CityGeneralDetails from './components/CityGeneralDetails';
import CurrentDateData from './components/CurrentDateData';
import FiveDaysForecast from './components/FiveDaysForecast';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = '';
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const location = target.value;
    this.setState({ location });
  }

  async handleSubmit(event) {
    event.preventDefault();
    this.location = this.state.location;
    const response = await fetch('/weather/' + this.location, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    const weatherData = await response.json();
    this.setState({ weatherData });
  }

  render() {

    const data = this.state;
    let weatherData, city, weatherDetails, currentDateWeather, currentTemp, fiveDaysForecast, currentDateWeatherByTime;
    if (data != null) {
      weatherData = data.weatherData;
      if (weatherData != null) {
        city = weatherData.city;
        weatherDetails = weatherData.weatherDetails;

        if (weatherDetails != null) {
          currentDateWeatherByTime = weatherDetails[0].weatherList;
          currentDateWeather = <CurrentDateData weatherDetails={currentDateWeatherByTime} />
          fiveDaysForecast = <FiveDaysForecast fiveDaysForecast={weatherDetails} />
          currentTemp = weatherDetails[0].weatherList[0].temp;
        }

        if (city != null) {
          city = <CityGeneralDetails city={city} temp={currentTemp} />
        }


      }
    }

    return (
      <section className="vh-100" style={{ backgroundColor: "#C1CFEA" }}>
        <MDBContainer className="h-100">
          <MDBRow
            className="justify-content-center align-items-center h-100"
            style={{ color: "#282828" }}
          >
            <MDBCol md="9" lg="7" xl="5">
              <MDBCard
                className="mb-4 gradient-custom"
                style={{ borderRadius: "25px" }}
              >
                <MDBCardBody className="p-4">
                  <div className="d-flex justify-content-between pb-2">
                    <InputSection onChange={this.handleChange} onClick={this.handleSubmit} />
                  </div>
                </MDBCardBody>
              </MDBCard>
              <MDBCard
                className="mb-4 gradient-custom"
                style={{ borderRadius: "25px", background: 'linear-gradient(to right, rgba(255, 255, 255, 1), rgba(255, 236, 210, 1))' }}
              >
                <MDBCardBody className="p-4">
                  {city}
                </MDBCardBody>
              </MDBCard>
              <MDBCard className="mb-4" style={{ borderRadius: "25px" }}>
                <MDBCardBody className="p-4">
                  {currentDateWeather}
                </MDBCardBody>
              </MDBCard>
              <MDBCard className="mb-4" style={{ borderRadius: "25px" }}>
                <MDBCardBody className="p-4">
                  {fiveDaysForecast}
                </MDBCardBody>
              </MDBCard>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </section >
    )
  }
}


/*class App extends Component {

  location = '';

  constructor(props) {
    super(props);
    this.state = '';
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const location = target.value;
    this.setState({ location });
  }

  async handleSubmit(event) {
    event.preventDefault();
    this.location = this.state.location;
    const response = await fetch('/weather/' + this.location, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    const city = await response.json();
    //console.log(city);
    this.setState({ city });
  }

  render() {
    const location = this.state;
    let city;
    if (location != null) {
      city = location.city;

      if (city != null) {
        city = <CityGeneralDetails sunrise={city.sunrise} sunset={city.sunset} name={city.name} country={city.country} />
      }
    }
    return (
      <section className="vh-100">

        <MDBContainer className="h-100 py-5">
          <MDBRow className="justify-content-center align-items-center h-100">
            <MDBCol md="8" lg="6" xl="4">
              <MDBTypography tag="h3" className="mb-4 pb-2 fw-normal">
                Check the weather forecast
              </MDBTypography>
              <MDBInputGroup className="mb-3">
                <InputSection onChange={this.handleChange} onClick={this.handleSubmit} />
              </MDBInputGroup>
              <MDBCard className="shadow-0 border">
                <MDBCardBody className="p-4">
                  {city}
                  <p className="mb-2">
                    Current temperature: <strong>5.42°C</strong>
                  </p>
                  <p>
                    Feels like: <strong>4.37°C</strong>
                  </p>
                  <p>
                    Max: <strong>6.11°C</strong>, Min: <strong>3.89°C</strong>
                  </p>
                  <div className="d-flex flex-row align-items-center">
                    <p className="mb-0 me-4">Scattered Clouds</p>
                    <MDBIcon fas icon="cloud" size="3x" style={{ color: '#eee' }} />
                  </div>
                </MDBCardBody>
              </MDBCard>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
        
      </section>

      /*<div>
          <form onSubmit={this.handleSubmit}>
            <div>Location:</div>
            <input type="text" name="location" id="location" onChange={this.handleChange}></input>
            <button type="submit">Get Weather</button>
          </form>
          <div>
            {url}
          </div>
          
        </div>
    )
  }
}*/

export default App;