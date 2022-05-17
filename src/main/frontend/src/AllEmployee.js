import {Component} from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Button, Table} from "react-bootstrap";

class AllEmployee extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees : []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/v1/employee").then(response =>{
            console.log(response);
            this.setState({

                employees : response.data
            })
        })
    }



    render() {
        const {employees} = this.state
        return(
            <div>
                <h2>List of employees</h2>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Mail</td>
                        <td>Department</td>
                        <td>Password</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        employees.map((employee) =>{
                            return(
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.mail}</td>
                                    <td>{employee.department}</td>
                                    <td>{employee.password}</td>
                                </tr>
                            )
                        })
                    }
                    </tbody>
                </Table>
                <div className={"text-center"}>
                    <Button variant={"primary"}>Add employee</Button>
                </div>
            </div>
        );
    }

}
export default AllEmployee;