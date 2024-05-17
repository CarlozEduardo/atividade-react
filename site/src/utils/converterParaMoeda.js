const converterParaMoeda = (valor, moeda) => {
  return valor.toLocaleString("pt-br", { style: "currency", currency: moeda });
};

export default converterParaMoeda;
