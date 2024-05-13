import styled from "styled-components";
import Header from "./components/Header/Header";
import Produtos from "./components/Produtos/Produtos";

const Container = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
`;

export default function App() {
  return (
    <Container>
      <Header />
      <Produtos />
    </Container>
  );
}
