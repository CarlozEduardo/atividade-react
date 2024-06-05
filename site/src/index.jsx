import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import axios from "axios";
import App from "./App.jsx";

const root = ReactDOM.createRoot(document.getElementById("root"));

function Cadastro() {
  const [emailInput, setEmailInput] = useState("");
  const [senhaInput, setSenhaInput] = useState("");
  const [cpfInput, setCPFInput] = useState("");
  const [nomeInput, setNomeInput] = useState("");

  const [mensagem, setMensagem] = useState("");

  const cadastrarUsuario = async (event) => {
    try {
      const response = await axios({
        method: "post",
        url: "http://localhost:8080/loja/cadastrar",
        data: {
          nome: nomeInput,
          email: emailInput,
          senha: senhaInput,
          cpf: cpfInput,
        },
      });
      setMensagem(response.data);
      console.log(mensagem);
      setMensagem("Cadastro realizado! indo para login...");

      setTimeout(() => {
        redirecionarLogin();
      }, 5000);
    } catch (error) {
      setMensagem(error);
    }
  };

  const redirecionarLogin = (event) => {
    event.preventDefault();
    root.render(<Login />);
  };

  return (
    <div className="page">
      <form className="formLogin" onSubmit={cadastrarUsuario}>
        <h2>Cadastro</h2>
        <p>Digite os seus dados de acesso no campo abaixo.</p>

        <label htmlFor="nome">Nome</label>
        <input
          type="input"
          placeholder="Digite seu nome"
          onChange={({ target }) => setNomeInput(target.value)}
        />
        <label htmlFor="cpf">CPF</label>
        <input
          type="input"
          placeholder="Digite seu CPF"
          onChange={({ target }) => setCPFInput(target.value)}
        />
        <label htmlFor="email">E-mail</label>
        <input
          type="email"
          placeholder="Digite seu e-mail"
          autoFocus={true}
          onChange={({ target }) => setEmailInput(target.value)}
        />
        <label htmlFor="password">Senha</label>
        <input
          type="password"
          placeholder="Digite sua senha"
          onChange={({ target }) => setSenhaInput(target.value)}
        />

        <a onClick={redirecionarLogin}>Já tenho conta</a>
        <input type="submit" value="Acessar" className="btn" />
        <p>{mensagem}</p>
      </form>
    </div>
  );
}

function Login() {
  const [emailInput, setEmailInput] = useState("");
  const [senhaInput, setSenhaInput] = useState("");
  const [mensagem, setMensagem] = useState("");

  const verificarLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get("http://localhost:8080/loja/login", {
        params: {
          email: emailInput,
          senha: senhaInput,
        },
      });
      sessionStorage.setItem("ID", response.data.id);
      setMensagem("Login realizado! indo para a loja...");

      setTimeout(() => {
        root.render(<App />);
      }, 5000);
    } catch (error) {
      setMensagem(error);
    }
  };

  const redirecionarCadastro = (event) => {
    event.preventDefault();

    root.render(<Cadastro />);
  };

  return (
    <div className="page">
      <form className="formLogin" onSubmit={verificarLogin}>
        <h2>Login</h2>
        <p>Digite os seus dados de acesso no campo abaixo.</p>
        <label htmlFor="email">E-mail</label>
        <input
          type="email"
          placeholder="Digite seu e-mail"
          autoFocus={true}
          onChange={({ target }) => setEmailInput(target.value)}
        />
        <label htmlFor="password">Senha</label>
        <input
          type="password"
          placeholder="Digite sua senha"
          onChange={({ target }) => setSenhaInput(target.value)}
        />
        <a onClick={redirecionarCadastro}>Não tenho conta</a>
        <input type="submit" value="Acessar" className="btn" />
        <p>{mensagem}</p>
      </form>
    </div>
  );
}

root.render(<Login />);
