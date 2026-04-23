import styled from 'styled-components'
import fLogo from '../../assets/img/f_logo.png'

function Footer() {
  return (
    <FooterWrapper>
      <div className="size">
        <Inner className="inner">
          <Address>
            <FLogo>
              <a href="#"><img src={fLogo} alt="로고" /></a>
            </FLogo>
            <ul>
              <li>
                <span className="c_name">성공건축자재</span>
              </li>
              <li>
                <span>인천시 계양구 동양동</span>
                <span className="width100">Tel : 02-1234-5678</span>
              </li>
              <li>
                <span>대표이사 : 서민구</span>
                <span>사업자등록번호 : 123-45-67890</span>
              </li>
            </ul>
            <Copy>Copyright 2025 codro. All Rights Reserved</Copy>
            <Util>
              <a href="#">개인정보취급방침</a>
            </Util>
          </Address>
        </Inner>
      </div>
    </FooterWrapper>
  )
}

export default Footer

const FooterWrapper = styled.footer`
  width: 100%;
  height: 160px;
  background: #333333;
`

const Inner = styled.div`
  height: 160px;
  padding: 40px 0 !important;
  box-sizing: border-box;
  position: relative;
`

const Address = styled.div`
  position: relative;
  padding-right: 190px;
  box-sizing: border-box;
  z-index: 1;

  ul {
    position: absolute;
    top: 10px;
    left: 140px;
  }

  ul li {
    overflow: hidden;
    margin-bottom: 5px;
    color: #fff;
    font-size: 14px;
    line-height: 20px;
    letter-spacing: -0.5px;
  }

  ul .c_name {
    font-size: 18px;
    margin-bottom: 15px;
    display: block;
    letter-spacing: -0.5px;
  }

  ul li span {
    display: inline-block;
    vertical-align: top;
    float: left;
    margin-left: 15px;
    font-weight: 400;
    color: #fff;

    &:first-child {
      margin-left: 0;
    }
  }
`

const FLogo = styled.div``

const Copy = styled.div`
  position: absolute;
  right: 0;
  top: 50px;
  color: rgba(255, 255, 255, 0.4);
  font-size: 12px;
  line-height: 20px;
  letter-spacing: -0.5px;
  font-weight: 300;
`

const Util = styled.div`
  position: absolute;
  right: 0;
  top: 0;
  z-index: 2;

  a {
    display: block;
    font-size: 14px;
    color: rgba(255, 255, 255, 0.8);
    width: 180px;
    height: 40px;
    line-height: 39px;
    border: 1px solid rgba(255, 255, 255, 0.8);
    text-align: center;
    letter-spacing: -1px;
  }
`
