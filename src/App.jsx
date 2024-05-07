import styled from "styled-components";
import Header from "./components/Header/Header";
const Container = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const Titulo = styled.h2``;

const Linha = styled.hr`
  width: 100%;
`;

function App() {
  return (
    <Container>
      <Header />
      <Container>
        <Titulo>Meu carrinho</Titulo>
        // Carrinho
      </Container>
      <Linha />
      <Container>
        <Titulo>Opções de compra</Titulo>
        // Opções
      </Container>
    </Container>
  );
}

export default App;
