import React, { useContext } from "react";
import RemoveShoppingCartIcon from "@mui/icons-material/RemoveShoppingCart";
import converterParaMoeda from "../../utils/converterParaMoeda";
import "./CartItem.css";
import AppContext from "../context/AppContext";

export default function CartItem({ data }) {
  const { cartItems, setCartItems } = useContext(AppContext);
  const { id, thumbnail, title, price } = data;

  const handleRemoveItem = () => {
    const updatedItems = cartItems.filter((item) => item.id != id);
    setCartItems(updatedItems);
  };

  return (
    <section className="cart-item">
      <img
        src={thumbnail}
        alt="imagem do produto"
        className="cart-item-image"
      />

      <div className="cart-item-content">
        <h3 className="cart-item-title">{title}</h3>
        <h3 className="cart-item-price">{converterParaMoeda(price, "BRL")}</h3>

        <button
          type="button"
          className="button__remove-item"
          onClick={handleRemoveItem}
        >
          <RemoveShoppingCartIcon />
        </button>
      </div>
    </section>
  );
}
