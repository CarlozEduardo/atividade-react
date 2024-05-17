import Cart from "./components/Cart/Cart";
import CartBotao from "./components/CartBotao/CartBotao";
import Header from "./components/Header/Header";
import Produtos from "./components/Produtos/Produtos";
import Provider from "./components/context/Provider";

export default function App() {
  return (
    <Provider>
      <CartBotao />
      <Header />
      <Produtos />

      <Cart />
    </Provider>
  );
}
