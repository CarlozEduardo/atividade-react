import React from "react";
import { useContext } from "react";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import "./CartBotao.css";
import AppContext from "../context/AppContext";

export default function CartBotao() {
  const { cartItems, isCartVisible, setIsCartVisible } = useContext(AppContext);

  return (
    <div className="cart-botao">
      <button
        type="button"
        className="cart__button"
        onClick={() => setIsCartVisible(!isCartVisible)}
      >
        <ShoppingCartIcon />
        {cartItems.length > 0 && (
          <span className="cart-status">{cartItems.length}</span>
        )}
      </button>
    </div>
  );
}
