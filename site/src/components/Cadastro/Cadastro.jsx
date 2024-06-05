import React from "react";

export default function Cadastro() {
  return (
    <section className="cadastro-section">
      <div>
        <form action="">
          <span>Email:</span>
          <input type="text" /> <br />
          <span>Senha:</span>
          <input type="password" />
          <button>CADASTRAR</button>
        </form>
      </div>
    </section>
  );
}
