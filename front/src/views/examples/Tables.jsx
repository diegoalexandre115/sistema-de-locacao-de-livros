import React from "react";
import AppConfig from "../../constants/AppConfig"

import api from '../../api'

// reactstrap components
import {
  Badge,
  Card,
  CardHeader,
  CardFooter,
  DropdownMenu,
  DropdownItem,
  UncontrolledDropdown,
  DropdownToggle,
  Media,
  Pagination,
  PaginationItem,
  PaginationLink,
  Progress,
  Table,
  Container,
  Row,
  UncontrolledTooltip
} from "reactstrap";
// core components
import Header from "components/Headers/Header.jsx";

class Tables extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      livros: [
      /*{  id: 1,
        nome: "Lord of the flies",
        preco: 30.00,
        quantidade: 3,
      },
      {
        id: 2,
        nome: "Lord of the rings",
        preco: 20.00,
        quantidade: 10,
      }
    */],
  
    }
  }
  async componentWillMount() {
    const livros = (await api.get(`${AppConfig.backend}/livros`)).data
    console.log(livros)
    this.setState({ livros })
}
  render() {
    const { livros } = this.state
    return (
      <>
        {<Header />}
        {/* Page content */}
        <Container className="mt--7" fluid>
         

          {/* Dark table */}
          <Row className="mt-5">
            <div className="col">
              <Card className="bg-default shadow">
                <CardHeader className="bg-transparent border-0">
                  <h3 className="text-white mb-0">Livros alugados na semana</h3>
                </CardHeader>
                <Table
                  className="align-items-center table-dark table-flush"
                  responsive
                >
                  <thead className="thead-dark">
                    <tr>
                      <th scope="col">Nome</th>
                      <th scope="col">Preco</th>                      
                    </tr>
                  </thead>
                  <tbody>
                    {livros.map(livro =>( 
                      <tr scope="row" key={livro.id}>
                      <td>{livro.nome}</td>
                      <td>{livro.preco}</td>
                      </tr>
                      ))}
                      
                    
                  </tbody>
                </Table>
              </Card>
            </div>
          </Row>
          {/* Dark table */}
          <Row className="mt-5">
            <div className="col">
              <Card className="bg-default shadow">
                <CardHeader className="bg-transparent border-0">
                  <h3 className="text-white mb-0">Livros devolvidos na semana</h3>
                </CardHeader>
                <Table
                  className="align-items-center table-dark table-flush"
                  responsive
                >
                  <thead className="thead-dark">
                    <tr>
                      <th scope="col">Nome</th>
                      <th scope="col">Preco</th>                      
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        
                          <Media>
                            <span className="mb-0 text-sm">
                              Argon Design System
                            </span>
                          </Media>
                        
                      </th>
                      <td>$2,500 USD</td>
                      
                      
                    </tr>
                    <tr>
                      <th scope="row">
                          <Media>
                            <span className="mb-0 text-sm">
                              Angular Now UI Kit PRO
                            </span>
                          </Media>
                        
                      </th>
                      <td>$1,800 USD</td>
                      
                      
                    </tr>
                    <tr>
                      <th scope="row">
                        
                          <Media>
                            <span className="mb-0 text-sm">
                              Black Dashboard
                            </span>
                          </Media>
                        
                      </th>
                      <td>$3,150 USD</td>
                      
                      
                    </tr>
                    <tr>
                      <th scope="row">
                        
                          <Media>
                            <span className="mb-0 text-sm">
                              React Material Dashboard
                            </span>
                          </Media>
                        
                      </th>
                      <td>$4,400 USD</td>
                      
                      
                    </tr>
                    <tr>
                      <th scope="row">
                        
                          <Media>
                            <span className="mb-0 text-sm">
                              Vue Paper UI Kit PRO
                            </span>
                          </Media>
                        
                      </th>
                      <td>$2,200 USD</td>
                      
                      
                    </tr>
                  </tbody>
                </Table>
              </Card>
            </div>
          </Row>
        </Container>
      </>
    );
  }
}

export default Tables;
