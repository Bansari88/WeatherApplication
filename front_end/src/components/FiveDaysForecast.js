import {
  MDBIcon,
} from "mdb-react-ui-kit";

export default function FiveDaysForecast(props) {
  const fiveDaysForecast = props.fiveDaysForecast;
  return (
    <div className="d-flex justify-content-around text-center pb-3 pt-2">
      <div className="flex-column">
        <p className="small">
          <strong>{fiveDaysForecast[1].weatherList[0].temp}°C</strong>
        </p>
        <MDBIcon
          fas
          icon={fiveDaysForecast[1].weatherList[0].weatherIcon}
          size="2x"
          className="mb-3"
          style={{ color: "#ddd" }}
        />
        <p className="mb-0">
          <strong>{fiveDaysForecast[1].day}</strong>
        </p>
      </div>
      <div className="flex-column">
        <p className="small">
          <strong>{fiveDaysForecast[2].weatherList[0].temp}°C</strong>
        </p>
        <MDBIcon
          fas
          icon={fiveDaysForecast[2].weatherList[0].weatherIcon}
          size="2x"
          className="mb-3"
          style={{ color: "#ddd" }}
        />
        <p className="mb-0">
          <strong>{fiveDaysForecast[2].day}</strong>
        </p>
      </div>
      <div className="flex-column">
        <p className="small">
          <strong>{fiveDaysForecast[3].weatherList[0].temp}°C</strong>
        </p>
        <MDBIcon
          fas
          icon={fiveDaysForecast[3].weatherList[0].weatherIcon}
          size="2x"
          className="mb-3"
          style={{ color: "#ddd" }}
        />
        <p className="mb-0">
          <strong>{fiveDaysForecast[3].day}</strong>
        </p>
      </div>
      <div className="flex-column">
        <p className="small">
          <strong>{fiveDaysForecast[4].weatherList[0].temp}°C</strong>
        </p>
        <MDBIcon
          fas
          icon={fiveDaysForecast[4].weatherList[0].weatherIcon}
          size="2x"
          className="mb-3"
          style={{ color: "#ddd" }}
        />
        <p className="mb-0">
          <strong>{fiveDaysForecast[4].day}</strong>
        </p>
      </div>
      <div className="flex-column">
        <p className="small">
          <strong>{fiveDaysForecast[5].weatherList[0].temp}°C</strong>
        </p>
        <MDBIcon
          fas
          icon={fiveDaysForecast[5].weatherList[0].weatherIcon}
          size="2x"
          className="mb-3"
          style={{ color: "#ddd" }}
        />
        <p className="mb-0">
          <strong>{fiveDaysForecast[5].day}</strong>
        </p>
      </div>
    </div>
  );
}