import React, { useContext, useState } from "react";

import "./Cart.css";
import CartItem from "../CartItems/CartItem";

import converterParaMoeda from "../../utils/converterParaMoeda";
import AppContext from "../context/AppContext";

export default function Cart() {
  const { cartItems, isCartVisible } = useContext(AppContext);
  const totalPrice = cartItems.reduce((acc, item) => item.price + acc, 0);

  return (
    <section className={`cart ${isCartVisible ? "cart--active" : ""}`}>
      <div className="cart-items">
        {cartItems.map((cartItem) => (
          <CartItem key={cartItem.id} data={cartItem} />
        ))}
      </div>

      <div className="cart-resume">
        {converterParaMoeda(totalPrice, "BRL")}
        <button className="button-resume">FINALIZAR COMPRA</button>
      </div>
    </section>
  );
}
