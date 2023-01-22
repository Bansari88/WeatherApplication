import {
    MDBIcon,
} from "mdb-react-ui-kit";

export default function CurrentDateData(props) {
    const weatherDetails = props.weatherDetails;
   
    return (
        <div className="d-flex justify-content-around text-center pb-3 pt-2">
            <div className="flex-column">
                <p className="small">
                    <strong>{weatherDetails[0].temp}°C</strong>
                </p>
                <MDBIcon
                    fas
                    icon={weatherDetails[0].weatherIcon}
                    size="2x"
                    className="mb-3"
                    style={{ color: "#ddd" }}
                />
                <p className="mb-0">
                    <strong>{weatherDetails[0].time}</strong>
                </p>
                <p hidden
                    className="mb-0 text-muted"
                    style={{ fontSize: ".65rem" }}
                >
                    PM
                </p>
            </div>
            <div className="flex-column">
                <p className="small">
                    <strong>{weatherDetails[1].temp}°C</strong>
                </p>
                <MDBIcon
                    fas
                    icon={weatherDetails[1].weatherIcon}
                    size="2x"
                    className="mb-3"
                    style={{ color: "#ddd" }}
                />
                <p className="mb-0">
                    <strong>{weatherDetails[1].time}</strong>
                </p>
                <p hidden
                    className="mb-0 text-muted"
                    style={{ fontSize: ".65rem" }}
                >
                    PM
                </p>
            </div>
            <div className="flex-column">
                <p className="small">
                    <strong>{weatherDetails[2].temp}°C</strong>
                </p>
                <MDBIcon
                    fas
                    icon={weatherDetails[2].weatherIcon}
                    size="2x"
                    className="mb-3"
                    style={{ color: "#ddd" }}
                />
                <p className="mb-0">
                    <strong>{weatherDetails[2].time}</strong>
                </p>
                <p hidden
                    className="mb-0 text-muted"
                    style={{ fontSize: ".65rem" }}
                >
                    PM
                </p>
            </div>
            <div className="flex-column">
                <p className="small">
                    <strong>{weatherDetails[3].temp}°C</strong>
                </p>
                <MDBIcon
                    fas
                    icon={weatherDetails[3].weatherIcon}
                    size="2x"
                    className="mb-3"
                    style={{ color: "#ddd" }}
                />
                <p className="mb-0">
                    <strong>{weatherDetails[3].time}</strong>
                </p>
                <p hidden
                    className="mb-0 text-muted"
                    style={{ fontSize: ".65rem" }}
                >
                    PM
                </p>
            </div>
            <div className="flex-column">
                <p className="small">
                    <strong>{weatherDetails[4].temp}°C</strong>
                </p>
                <MDBIcon
                    fas
                    icon={weatherDetails[4].weatherIcon}
                    size="2x"
                    className="mb-3"
                    style={{ color: "#ddd" }}
                />
                <p className="mb-0">
                    <strong>{weatherDetails[4].time}</strong>
                </p>
                <p hidden
                    className="mb-0 text-muted"
                    style={{ fontSize: ".65rem" }}
                >
                    PM
                </p>
            </div>
        </div>
    );
}