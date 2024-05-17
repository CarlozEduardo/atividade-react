import React, { useState } from "react";
import AppContext from "./AppContext";

export default function Provider({ children }) {
  const [pesquisa, setPesquisa] = useState("");
  const [produtos, setProdutos] = useState([]);
  const [cartItems, setCartItems] = useState([]);
  const [isCartVisible, setIsCartVisible] = useState(false);

  const value = {
    pesquisa,
    setPesquisa,
    produtos,
    setProdutos,
    cartItems,
    setCartItems,
    isCartVisible,
    setIsCartVisible,
  };

  return <AppContext.Provider value={value}>{children}</AppContext.Provider>;
}
