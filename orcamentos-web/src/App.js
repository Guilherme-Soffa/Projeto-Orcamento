import React from 'react';
import './App.css';
import Orcamentos from './Orcamento';
import DetalharOrcamento from './DetalharOrcamento';

function App() {

  const [orcamentoDetalhar, setOrcamentoDetalhar] = React.useState(null)

  return (
    <>
    {
      orcamentoDetalhar == null ? <Orcamentos setOrcamentoDetalhar={setOrcamentoDetalhar} />
      : <DetalharOrcamento  setOrcamentoDetalhar={setOrcamentoDetalhar} orcamento={orcamentoDetalhar}/>
    }
     </>
  );
}

export default App;
