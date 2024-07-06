import React, { useState } from "react";
import { Nav, Navbar, NavLink, NavbarToggler, NavbarBrand, NavItem, Collapse } from "reactstrap";
import { Link } from "react-router-dom";

function AppNavBar() {

  const [isOpen, setIsOpen] = useState(false);

  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
      <NavbarToggler onClick={() => setIsOpen(!isOpen)} />
      <Collapse isOpen={isOpen} navbar>
        <Nav className="justify-content-end" style={{ width: "100%" }} navbar>
          <NavItem></NavItem>
        </Nav>
      </Collapse>
    </Navbar>
  );
}

export default AppNavBar;


