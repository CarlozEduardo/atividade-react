import { useState, useEffect } from "react";

import fetchProdutos from "../../services/api-mercado/fetchProdutos";
import CardProduto from "../CardProduto/CardProduto";
import "./Produtos.css";

export default function Produtos() {
  const [produtos, setProdutos] = useState([]);

  useEffect(() => {
    fetchProdutos("teclado").then((resposta) => {
      setProdutos(resposta);
    });
  }, []);

  return (
    <section>
      <h1>Resultado para iphone</h1>
      <div className="container-card">
        {produtos.map((produto) => (
          <CardProduto data={produto} />
        ))}
      </div>
    </section>
  );
}
