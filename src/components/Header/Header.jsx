import { useContext, useState } from "react";
import "./Header.css";
import SearchIcon from "@mui/icons-material/Search";
import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import AppContext from "../context/AppContext";

export default function Header() {
  const [input, setInput] = useState("");

  const { setPesquisa } = useContext(AppContext);

  const handleProcurar = (event) => {
    event.preventDefault(); // event
    setPesquisa(input);
  };

  return (
    <header>
      <div className="container">
        <div className="nome">
          <LocalGroceryStoreIcon color="white" />
          <h3>Lojinha do Carlos</h3>
        </div>

        <form className="search-bar" onSubmit={handleProcurar}>
          <input
            value={input}
            placeholder="Buscar produtos"
            className="search__input"
            onChange={({ target }) => setInput(target.value)}
            required
          />
          <button type="submit" className="search__button">
            <SearchIcon />
          </button>
        </form>
      </div>
    </header>
  );
}
