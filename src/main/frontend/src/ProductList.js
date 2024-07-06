import React, { useEffect, useState } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import { Link } from "react-router-dom";
import AppNavBar from "./AppNavBar";

function ProductList() {

  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch("/products")
      .then(response => response.json())
      .then(data => {
        setProducts(data);
        setLoading(false);
      });
  }, [])

  async function remove(id) {
    await fetch(`/product/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    })
      .then(() => {
        let updatedProducts = [...products].filter(product => product.productID !== id);
        setProducts(updatedProducts);
      });
  }

  if (loading) {
    return <p>Loading...</p>
  }

  const productList = products.map(
    product => {
      return <tr key={product.productID}>
        <td>{product.productName}</td>
        <td>{product.description}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/product/" + product.productID}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => remove(product.productID)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    }
  );

  return (
    <div>
      <AppNavBar />
      <Container fluid>
        <div className="float-end">
          <Button color="success" tag={Link} to={"/product/new"}>Add Product</Button>
        </div>
        <h3>Products</h3>
        <Table className="mt-4" >
          <thead>
            <tr>
              <th width="20%">Name</th>
              <th>Description</th>
              <th width="10%">Action</th>
            </tr>
          </thead>
          <tbody>
            {productList}
          </tbody>
        </Table>
      </Container>
    </div>
  );
}

export default ProductList;


