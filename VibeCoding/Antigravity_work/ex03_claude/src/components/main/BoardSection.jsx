import styled from 'styled-components'
import icoTop from '../../assets/img/ico_top.png'
import plusR from '../../assets/img/plus_r.png'
import csIco from '../../assets/img/cs_ico.png'
import inqIco from '../../assets/img/inq_ico.png'
import plusW from '../../assets/img/plus_w.png'

const notices = [
  { isTop: true, title: '성공건축자재 홈페이지를 오픈하였습니다.', date: '2018-08-01' },
  { isTop: false, title: '성공건축자재 홈페이지를 오픈하였습니다.', date: '2018-08-01' },
  { isTop: false, title: '성공건축자재 홈페이지를 오픈하였습니다.', date: '2018-08-01' },
]

function BoardSection() {
  return (
    <Section>
      <div className="size">
        <BbsWrap>
          <Inner className="clear">
            {/* 공지사항 */}
            <BbsBox>
              <strong>공지사항</strong>
              <NoticeList>
                {notices.map((notice, i) => (
                  <li key={i}>
                    <a href="#">
                      <Subject>
                        {notice.isTop && <img src={icoTop} alt="TOP공지" />}
                        {notice.title}
                      </Subject>
                      <span className="date">{notice.date}</span>
                    </a>
                  </li>
                ))}
              </NoticeList>
              <BtnMore>
                <a href="#">더보기 <img src={plusR} alt="+" /></a>
              </BtnMore>
            </BbsBox>

            {/* 고객센터 */}
            <BbsBoxCenter>
              <strong>고객센터</strong>
              <p className="ico"><img src={csIco} alt="고객센터" /></p>
              <CsPhone href="tel:02-1234-5678">02-1234-5678</CsPhone>
              <CsDesc>
                <p>FAX: 02-1234-5678</p>
                <p>E-MAIL: codro.ceo@codro.it</p>
              </CsDesc>
            </BbsBoxCenter>

            {/* 견적문의 */}
            <BbsBoxInq>
              <strong>견적문의</strong>
              <p className="ico"><img src={inqIco} alt="견적문의" /></p>
              <InqDesc>
                항상 최고의 품질을 제품들을 제공하기 위해 <br />
                성공건축자재는 항상 최선을 다하겠습니다.
              </InqDesc>
              <InqBtn href="#">견적문의하기 <img src={plusW} alt="+" /></InqBtn>
            </BbsBoxInq>
          </Inner>
        </BbsWrap>
      </div>
    </Section>
  )
}

export default BoardSection

const Section = styled.section`
  padding: 60px 0;
`

const BbsWrap = styled.div`
  width: 100%;
  position: relative;
`

const Inner = styled.div`
  width: 102%;
  margin-left: -2%;
`

const BbsBox = styled.div`
  width: 31.3333%;
  margin-left: 2%;
  float: left;
  box-sizing: border-box;
  padding: 20px;
  border: 1px solid #dadada;
  min-height: 270px;

  > strong {
    display: block;
    text-align: center;
    color: #373131;
    font-size: 26px;
  }
`

const BbsBoxCenter = styled(BbsBox)`
  text-align: center;

  > strong {
    color: #373131;
  }

  .ico {
    padding: 20px 0;
    text-align: center;
  }
`

const BbsBoxInq = styled(BbsBox)`
  border: 0;
  background: #f3f3f3;
  text-align: center;

  > strong {
    color: ${({ theme }) => theme.colors.primary};
  }

  .ico {
    padding: 20px 0;
    text-align: center;
  }
`

const NoticeList = styled.ul`
  padding: 20px 0;
  min-height: 108px;

  li a {
    width: 100%;
    display: block;
    padding-right: 85px;
    box-sizing: border-box;
    border-bottom: 1px dotted #dadada;
    position: relative;
    line-height: 35px;
    transition: all 0.2s;

    &:hover {
      background: rgba(155, 155, 155, 0.1);
    }
  }
`

const Subject = styled.div`
  width: 100%;
  display: block;
  max-width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 16px;
  font-weight: 400;
  color: #333333;

  img {
    margin-right: 5px;
    margin-top: -2px;
  }
`

const BtnMore = styled.div`
  text-align: center;

  a {
    display: inline-block;
    width: 130px;
    height: 35px;
    border-radius: 35px;
    border: 2px solid ${({ theme }) => theme.colors.primary};
    color: ${({ theme }) => theme.colors.primary};
    line-height: 31px;
    font-size: 16px;
    font-weight: 600;

    img {
      margin-top: -4px;
      margin-left: 4px;
    }
  }
`

const CsPhone = styled.a`
  display: inline-block;
  text-align: center;
  color: ${({ theme }) => theme.colors.primary} !important;
  font-size: 32px;
  line-height: 1;
  font-weight: 900;
`

const CsDesc = styled.div`
  padding-top: 20px;
  color: #5c5b5e;
  font-size: 16px;
  font-weight: 300;
`

const InqDesc = styled.div`
  color: #5c5b5e;
  font-size: 16px;
  font-weight: 300;
`

const InqBtn = styled.a`
  display: inline-block;
  margin: 20px auto 0;
  width: 160px;
  height: 35px;
  border-radius: 35px;
  line-height: 33px;
  background: ${({ theme }) => theme.colors.primary};
  color: #fff !important;
  font-size: 16px;
  font-weight: 600;

  img {
    margin-top: -4px;
    margin-left: 4px;
  }
`
