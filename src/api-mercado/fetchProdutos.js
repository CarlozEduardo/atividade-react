const fetchProdutos = async (query) => {
  const resposta = await fetch(
    `https://api.mercadolibre.com/sites/MLB/search?q=${query}`
  );
  const data = await resposta.json();

  return data.results;
};

export default fetchProdutos;
