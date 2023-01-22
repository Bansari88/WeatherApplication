export default function InputSection(props) {
    return (
        <table>
            <tbody>
                <tr>
                    <td>
                        <input
                            className="form-control rounded"
                            type="text"
                            placeholder="City" onChange={props.onChange}
                        />
                    </td>
                    <td>
                        <a href="#!" type="button" onClick={props.onClick}>
                            <span
                                className="input-group-text border-0 fw-bold"
                                id="search-addon"
                            >
                                Check!
                            </span>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    );
}