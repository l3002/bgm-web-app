import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";
import AppNavBar from "./AppNavBar";


function ProductEdit() {

  const initialProductForm = {
    productName: '',
    description: ''
  };

  const [product, setProduct] = useState(initialProductForm);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== 'new') {
      fetch(`/product/${id}`)
        .then(response => response.json())
        .then(data => setProduct(data));
    }
  }, [id, setProduct]);

  const handleChange = (event) => {

    const { name, value } = event.target
    setProduct({ ...product, [name]: value });

  }

  const handleSubmit = async (event) => {
    event.preventDefault();

    await fetch(`/product${product.productID ? `/${product.productID}` : '/new'}`, {
      method: (product.productID) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product)
    });
    setProduct(initialProductForm);
    navigate('/products');
  }

  const title = <h2>{product.productID ? "Edit Product" : "Add Product"}</h2>;

  return (
    <div>
      <AppNavBar />
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Label for="productName">Name</Label>
            <Input type="text" name="productName" id="productName" value={product.productName || ''}
              onChange={handleChange} autoComplete="name" />
          </FormGroup>
          <FormGroup>
            <Label for="description">Description</Label>
            <Input type="text" name="description" id="description" value={product.description || ''}
              onChange={handleChange} />
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/products">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
}

export default ProductEdit;

