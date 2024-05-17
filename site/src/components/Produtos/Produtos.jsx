import { useContext, useEffect } from "react";

import fetchProdutos from "../../services/api-mercado/fetchProdutos";
import CardProduto from "../CardProduto/CardProduto";
import "./Produtos.css";
import AppContext from "../context/AppContext";

export default function Produtos() {
  const { produtos, setProdutos, pesquisa } = useContext(AppContext);

  useEffect(() => {
    const fetchData = async () => {
      const resposta = await fetchProdutos(pesquisa);
      setProdutos(resposta);
    };

    fetchData();
  }, [pesquisa, setProdutos]);

  return (
    <section>
      {pesquisa != "" && (
        <h1>
          Resultado para <b>{pesquisa}</b>
        </h1>
      )}
      <div className="container-card">
        {produtos.map((produto) => (
          <CardProduto key={produto.id} data={produto} />
        ))}
      </div>
    </section>
  );
}
