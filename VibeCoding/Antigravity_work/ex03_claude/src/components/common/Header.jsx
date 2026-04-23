import { useState } from 'react'
import styled from 'styled-components'
import logo from '../../assets/img/logo.png'
import menuIco from '../../assets/img/menu_ico.png'
import menuCloseIco from '../../assets/img/menu_close_ico.png'

const gnbMenus = [
  {
    label: '회사소개',
    depth2: ['인사말', '연혁', '조직도', '오시는길'],
  },
  {
    label: '제품소개',
    depth2: ['벽면', '바닥', '도어', '몰딩', '시트', '가구'],
  },
  {
    label: '시공사례',
    depth2: ['시공실적', '시공갤러리'],
  },
  {
    label: '견적문의',
    depth2: ['견적문의'],
  },
  {
    label: '고객센터',
    depth2: ['성공소식', '보도자료'],
  },
]

function Header() {
  const [isAllGnbOpen, setIsAllGnbOpen] = useState(false)
  const [activeIndex, setActiveIndex] = useState(null)

  return (
    <HeaderWrapper>
      <div className="size">
        <Inner className="inner clear">
          <Logo className="Abs_lc">
            <a href="/"><img src={logo} alt="로고" /></a>
          </Logo>

          <Gnb>
            <ul className="clear">
              {gnbMenus.map((menu, i) => (
                <GnbItem
                  key={i}
                  onMouseEnter={() => setActiveIndex(i)}
                  onMouseLeave={() => setActiveIndex(null)}
                >
                  <a href="#">{menu.label}</a>
                  <Depth2 $visible={activeIndex === i}>
                    {menu.depth2.map((sub, j) => (
                      <li key={j}><a href="#">{sub}</a></li>
                    ))}
                  </Depth2>
                </GnbItem>
              ))}
            </ul>
          </Gnb>

          <MenuBtn className="Abs_rc">
            <AllMenuBtn
              href="#"
              $isOpen={isAllGnbOpen}
              onClick={(e) => {
                e.preventDefault()
                setIsAllGnbOpen(!isAllGnbOpen)
              }}
            >
              전체메뉴
            </AllMenuBtn>
          </MenuBtn>
        </Inner>
      </div>

      <AllGnb $visible={isAllGnbOpen}>
        <div className="size">
          <div className="inner clear">
            <Menus>
              {gnbMenus.map((menu, i) => (
                <MenuGroup key={i} $active={activeIndex === i}>
                  {menu.depth2.map((sub, j) => (
                    <li key={j}><a href="#">{sub}</a></li>
                  ))}
                </MenuGroup>
              ))}
            </Menus>
          </div>
        </div>
      </AllGnb>
    </HeaderWrapper>
  )
}

export default Header

const HeaderWrapper = styled.header`
  width: 100%;
  position: fixed;
  height: 90px;
  z-index: 100;
  background: #fff;
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  box-sizing: border-box;
`

const Inner = styled.div`
  padding-left: 120px !important;
  padding-right: 70px !important;
`

const Logo = styled.h1`
  margin-top: -25px;
  display: block;
  position: absolute;
  left: 0;
  top: 50%;

  a {
    display: block;
    font-size: 0;
    padding: 10px 0;
  }
`

const Gnb = styled.nav`
  float: right;
  box-sizing: border-box;

  > ul {
    display: flex;
  }
`

const GnbItem = styled.li`
  height: 90px;
  padding: 20px 0;
  position: relative;
  box-sizing: border-box;

  > a {
    display: block;
    height: 50px;
    line-height: 50px;
    width: 140px;
    text-align: center;
    font-size: 19px;
    color: #373131;
    transition: color 0.3s;

    &:hover {
      color: ${({ theme }) => theme.colors.primary};
    }
  }
`

const Depth2 = styled.ul`
  display: ${({ $visible }) => ($visible ? 'block' : 'none')};
  position: absolute;
  z-index: 100;
  background: rgba(0, 0, 0, 0.6);
  width: 100%;
  top: 90px;
  border-top: 2px solid ${({ theme }) => theme.colors.primary};
  box-sizing: border-box;
  padding: 10px 0;
  left: 0;

  li a {
    display: block;
    text-align: center;
    font-size: 16px;
    height: 40px;
    line-height: 40px;
    color: #fff;

    &:hover {
      color: ${({ theme }) => theme.colors.primary};
    }
  }
`

const MenuBtn = styled.div`
  margin-top: -25px;
  z-index: 100;
  right: 0;
  position: absolute;
  top: 50%;
`

const AllMenuBtn = styled.a`
  display: block;
  width: 50px;
  height: 50px;
  line-height: 50px;
  text-indent: -9999px;
  background: url(${({ $isOpen }) => ($isOpen ? menuCloseIco : menuIco)}) no-repeat center center;
  font-size: 0;
  color: #fff;
  text-align: center;
`

const AllGnb = styled.div`
  display: ${({ $visible }) => ($visible ? 'block' : 'none')};
  position: absolute;
  top: 90px;
  left: 0;
  width: 100%;
  z-index: 101;
  background: rgba(0, 0, 0, 0.6);
`

const Menus = styled.div`
  float: right;
  display: flex;
`

const MenuGroup = styled.ul`
  float: left;
  width: 140px;
  padding: 10px 0;
  box-sizing: border-box;
  position: relative;

  &::before {
    position: absolute;
    top: 0;
    left: ${({ $active }) => ($active ? '0' : '50%')};
    width: ${({ $active }) => ($active ? '100%' : '0')};
    height: 2px;
    background: ${({ theme }) => theme.colors.primary};
    clear: both;
    content: '';
    display: block;
    transition: all 0.3s;
  }

  li a {
    display: block;
    height: 40px;
    line-height: 40px;
    color: #fff;
    font-size: 16px;
    text-align: center;

    &:hover {
      color: ${({ theme }) => theme.colors.primary};
    }
  }
`
