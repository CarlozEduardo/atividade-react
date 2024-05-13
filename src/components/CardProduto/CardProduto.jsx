import converterParaMoeda from "../../utils/converterParaMoeda";
import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import "./CardProduto.css";

export default function CardProduto({ data }) {
  const { thumbnail, title, price } = data;

  return (
    <section className="card">
      <img
        src={thumbnail.replace(/\w\.jpg/gi, "W.jpg")}
        alt="produto"
        className="imagem_card"
      />

      <div className="informacoes_card">
        <h2 className="preco_card">{converterParaMoeda(price, "BRL")}</h2>
        <h2 className="titulo_card">{title}</h2>
      </div>

      <button type="botao" className="botao_add_carrinho">
        <LocalGroceryStoreIcon />
      </button>
    </section>
  );
}
