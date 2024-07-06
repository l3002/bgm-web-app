import React from "react";
import "./App.css";
import AppNavBar from "./AppNavBar";
import { Link } from "react-router-dom";
import { Button, Container } from "reactstrap";


function Home() {
  return (
    <div>
      <AppNavBar />
      <Container fluid>
        <Button color="link"><Link to="/products">Manage Products</Link></Button>
      </Container>
    </div>
  );
}

export default Home;
