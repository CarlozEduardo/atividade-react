import React, { useContext } from "react";

import "./Cart.css";
import CartItem from "../CartItems/CartItem";

import converterParaMoeda from "../../utils/converterParaMoeda";
import AppContext from "../context/AppContext";
import axios from "axios";

export default function Cart() {
  const { cartItems, isCartVisible, setCartItems } = useContext(AppContext);
  const totalPrice = cartItems.reduce((acc, item) => item.price + acc, 0);

  const finalizarVenda = async (event) => {
    event.preventDefault();

    await axios({
      method: "post",
      url: "http://localhost:8080/produto/cadastrar",
      data: cartItems.map((cartItem) => ({
        id: cartItem.id,
        nome: cartItem.title,
        preco: cartItem.price,
      })),
      headers: {
        "Content-Type": "application/json",
      },
    }).catch((error) => {
      console.error("Erro ao fazer requisição:", error);
    });

    await axios({
      method: "post",
      url: "http://localhost:8080/venda/cadastrar",
      data: {
        vendaDTO: {
          precoTotal: totalPrice,
          fkCliente: parseInt(sessionStorage.ID, 10),
        },
        produtos: cartItems.map((cartItem) => cartItem.id.toString()),
      },
      headers: {
        "Content-Type": "application/json",
      },
    }).catch((error) => {
      console.error(error);
    });

    alert("Compra realizada! Obrigado por confiar em nós");

    setCartItems([]);
  };

  return (
    <section className={`cart ${isCartVisible ? "cart--active" : ""}`}>
      <div className="cart-items">
        {cartItems.map((cartItem) => (
          <CartItem key={cartItem.id} data={cartItem} />
        ))}
      </div>

      <div className="cart-resume">
        {converterParaMoeda(totalPrice, "BRL")}
        <button onClick={finalizarVenda} className="button-resume">
          FINALIZAR COMPRA
        </button>
      </div>
    </section>
  );
}
