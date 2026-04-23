import Header from '../components/common/Header'
import Footer from '../components/common/Footer'
import VisualSlider from '../components/main/VisualSlider'
import ProductSection from '../components/main/ProductSection'
import ConstructionCase from '../components/main/ConstructionCase'
import BoardSection from '../components/main/BoardSection'
import styled from 'styled-components'

const Wrapper = styled.div`
  width: 100%;
  position: relative;
  margin: 0 auto;
  min-height: 600px;
`

const Main = styled.div`
  width: 100%;
  padding-top: ${({ theme }) => theme.sizes.headerHeight};
`

function MainPage() {
  return (
    <Wrapper>
      <Header />
      <Main>
        <VisualSlider />
        <ProductSection />
        <ConstructionCase />
        <BoardSection />
      </Main>
      <Footer />
    </Wrapper>
  )
}

export default MainPage
