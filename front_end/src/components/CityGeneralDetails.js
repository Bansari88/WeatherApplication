export default function CityGeneralDetails(props) {
    const city = props.city;
    return (
        <div className="d-flex justify-content-between pb-2">
            <div>
                <h2 className="display-2">
                    <strong>{props.temp}°C</strong>
                </h2>
                <p className="text-muted mb-0">{city.cityName}, {city.country}</p>
            </div>
            <div>
                <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-weather/ilu3.webp"
                    width="150px"
                />
            </div>
        </div>

    );
}