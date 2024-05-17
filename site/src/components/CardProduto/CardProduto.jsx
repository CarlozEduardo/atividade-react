import converterParaMoeda from "../../utils/converterParaMoeda";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import "./CardProduto.css";
import { useContext } from "react";
import AppContext from "../context/AppContext";

export default function CardProduto({ data }) {
  const { thumbnail, title, price } = data;
  const { cartItems, setCartItems } = useContext(AppContext);

  const salvarCart = () => {
    setCartItems([...cartItems, data]);
  };

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

      <button onClick={salvarCart} type="botao" className="botao_add_carrinho">
        <AddShoppingCartIcon />
      </button>
    </section>
  );
}
