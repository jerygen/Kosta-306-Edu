import styled from 'styled-components'
import { Swiper, SwiperSlide } from 'swiper/react'
import { Navigation } from 'swiper/modules'
import 'swiper/css'
import 'swiper/css/navigation'
import round01 from '../../assets/img/round_01.png'
import round02 from '../../assets/img/round_02.png'
import round03 from '../../assets/img/round_03.png'
import round04 from '../../assets/img/round_04.png'
import round05 from '../../assets/img/round_05.png'
import round06 from '../../assets/img/round_06.png'
import roundIco01 from '../../assets/img/round_ico01.png'
import roundIco02 from '../../assets/img/round_ico02.png'
import roundIco03 from '../../assets/img/round_ico03.png'
import roundIco04 from '../../assets/img/round_ico04.png'
import roundIco05 from '../../assets/img/round_ico05.png'
import roundIco06 from '../../assets/img/round_ico06.png'
import prevIco from '../../assets/img/prev_ico.png'
import nextIco from '../../assets/img/next_ico.png'

const products = [
  { bg: round01, ico: roundIco01, label: '벽면' },
  { bg: round02, ico: roundIco02, label: '바닥' },
  { bg: round03, ico: roundIco03, label: '도어' },
  { bg: round04, ico: roundIco04, label: '몰딩' },
  { bg: round05, ico: roundIco05, label: '시트' },
  { bg: round06, ico: roundIco06, label: '가구' },
]

function ProductSection() {
  return (
    <Section>
      <div className="size">
        <SectionTitle>
          <h3>product</h3>
          <p>지속적인 변화와 혁신으로 더 나은 세상을 만들어가겠습니다</p>
        </SectionTitle>
        <RoundWrap>
          <StyledSwiper
            modules={[Navigation]}
            navigation={{
              nextEl: '.nbt2',
              prevEl: '.pbt2',
            }}
            slidesPerView={5}
            spaceBetween={30}
            loop={true}
          >
            {products.map((product, i) => (
              <SwiperSlide key={i}>
                <RoundItem href="#" $bg={product.bg}>
                  <div className="round">
                    <Overlay>
                      <div className="tb">
                        <div className="tbc">
                          <p className="ico"><img src={product.ico} alt={product.label} /></p>
                          <p>{product.label}</p>
                        </div>
                      </div>
                    </Overlay>
                  </div>
                </RoundItem>
              </SwiperSlide>
            ))}
          </StyledSwiper>
          <PrevBtn className="pbt2 swiper-button-prev" />
          <NextBtn className="nbt2 swiper-button-next" />
        </RoundWrap>
      </div>
    </Section>
  )
}

export default ProductSection

const Section = styled.section`
  padding: 60px 0;
`

const SectionTitle = styled.div`
  text-align: center;

  h3 {
    font-family: 'Raleway', sans-serif;
    font-weight: 800;
    text-transform: uppercase;
    color: ${({ theme }) => theme.colors.primary};
    font-size: 45px;
    letter-spacing: -1px;
  }

  p {
    color: #515155;
    font-size: 18px;
    font-weight: 400;
    letter-spacing: -0.5px;
  }
`

const RoundWrap = styled.div`
  margin-top: 40px;
  position: relative;
`

const StyledSwiper = styled(Swiper)`
  width: 100%;
`

const RoundItem = styled.a`
  display: block;
  width: 236px;
  height: 236px;
  position: relative;
  border-radius: 50%;
  background-image: url(${({ $bg }) => $bg});
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  transition: all 0.4s;

  .round {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    overflow: hidden;
  }

  &:hover > .round > div {
    background: rgba(243, 115, 57, 0.8);
  }
`

const Overlay = styled.div`
  position: absolute;
  width: 70%;
  height: 70%;
  left: 15%;
  top: 15%;
  border-radius: 80%;
  text-align: center;
  background: transparent;
  color: #fff;
  transition: all 0.4s;
  pointer-events: none;

  p {
    color: #fff;
    font-size: 14px;
  }
`

const PrevBtn = styled.div`
  width: 18px !important;
  height: 33px !important;
  margin-top: -16.5px !important;
  left: -38px !important;
  background: url(${prevIco}) no-repeat center center !important;

  &::after {
    display: none !important;
  }
`

const NextBtn = styled.div`
  width: 18px !important;
  height: 33px !important;
  margin-top: -16.5px !important;
  right: -38px !important;
  background: url(${nextIco}) no-repeat center center !important;

  &::after {
    display: none !important;
  }
`
