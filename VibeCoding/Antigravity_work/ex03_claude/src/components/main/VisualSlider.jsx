import styled from 'styled-components'
import { Swiper, SwiperSlide } from 'swiper/react'
import { Navigation, Pagination } from 'swiper/modules'
import 'swiper/css'
import 'swiper/css/navigation'
import 'swiper/css/pagination'
import visual01 from '../../assets/img/visual01.jpg'
import visualPrev from '../../assets/img/visual_prev.png'
import visualNext from '../../assets/img/visual_next.png'

const slides = [
  { className: 'bg1', bgImage: visual01, bgColor: null },
  { className: 'bg2', bgImage: null, bgColor: '#ccc' },
  { className: 'bg3', bgImage: null, bgColor: '#aac' },
  { className: 'bg4', bgImage: null, bgColor: '#fa3' },
  { className: 'bg5', bgImage: null, bgColor: '#7ac' },
]

function VisualSlider() {
  return (
    <VisualWrapper>
      <StyledSwiper
        modules={[Navigation, Pagination]}
        navigation={{
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        }}
        pagination={{ clickable: true }}
        loop={true}
      >
        {slides.map((slide, i) => (
          <SwiperSlide key={i}>
            <Slide $bgImage={slide.bgImage} $bgColor={slide.bgColor}>
              <div className="txt">
                <div className="slogun">
                  <p className="rale">new dream</p>
                  <strong className="rale-exbold">we build</strong>
                </div>
                <div className="desc">
                  <p>
                    최고의 제품과 최고의 서비스로 <br />고객만족을 실현합니다.
                  </p>
                </div>
              </div>
            </Slide>
          </SwiperSlide>
        ))}
        <PrevBtn className="swiper-button-prev" />
        <NextBtn className="swiper-button-next" />
      </StyledSwiper>
    </VisualWrapper>
  )
}

export default VisualSlider

const VisualWrapper = styled.div`
  width: 100%;
  position: relative;
`

const StyledSwiper = styled(Swiper)`
  width: 100%;
  height: 750px;

  .swiper-pagination-bullet {
    width: 36px;
    height: 4px;
    background: #fff;
    border-radius: 0;
    opacity: 1;
  }

  .swiper-pagination-bullet-active {
    height: 6px;
  }
`

const Slide = styled.div`
  width: 100%;
  height: 750px;
  background-image: ${({ $bgImage }) => ($bgImage ? `url(${$bgImage})` : 'none')};
  background-color: ${({ $bgColor }) => $bgColor || 'transparent'};
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;

  .slogun {
    padding: 30px 50px 0;
    color: ${({ theme }) => theme.colors.primary};
    text-transform: uppercase;
    line-height: 0.9;
    position: relative;
    border: 6px solid ${({ theme }) => theme.colors.primary};
    border-bottom: 0;
    text-shadow: 1px 1px 1px rgba(119, 34, 34, 0.5);

    &::after {
      position: absolute;
      bottom: -6px;
      left: -6px;
      width: 50px;
      height: 6px;
      background: ${({ theme }) => theme.colors.primary};
      content: '';
      display: block;
    }

    &::before {
      position: absolute;
      bottom: -6px;
      right: -6px;
      width: 50px;
      height: 6px;
      background: ${({ theme }) => theme.colors.primary};
      content: '';
      display: block;
    }

    p {
      font-size: 50px;
    }

    strong {
      display: block;
      font-size: 85px;
    }
  }

  .desc {
    color: #fff;
    font-size: 24px;
    line-height: 1.3;
    padding-top: 40px;
    padding-bottom: 40px;
  }
`

const PrevBtn = styled.div`
  width: 58px !important;
  height: 57px !important;
  margin-top: -28.5px !important;
  background-image: url(${visualPrev}) !important;
  background-repeat: no-repeat !important;
  background-size: contain !important;
  background-position: center center !important;
  left: 45px !important;

  &::after {
    display: none !important;
  }
`

const NextBtn = styled.div`
  width: 58px !important;
  height: 57px !important;
  margin-top: -28.5px !important;
  background-image: url(${visualNext}) !important;
  background-repeat: no-repeat !important;
  background-size: contain !important;
  background-position: center center !important;
  right: 45px !important;

  &::after {
    display: none !important;
  }
`
