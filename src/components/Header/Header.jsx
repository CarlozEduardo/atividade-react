import { useState } from "react";
import "./Header.css";
import SearchIcon from "@mui/icons-material/Search";
import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";

function Header() {
  const [input, setInput] = useState("");

  const procurar = () => {
    //   useEffect(() => {
    //     const resposta = await;
    //   });
  };

  return (
    <header>
      <div className="container">
        <div>
          <LocalGroceryStoreIcon color="action" />
          <h3>Lojinha do Carlos</h3>
        </div>

        <form className="search-bar" onSubmit={procurar}>
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

export default Header;
