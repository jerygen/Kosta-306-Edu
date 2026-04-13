import { Outlet } from 'react-router-dom';

const AboutLayout = () => {
  return (
    <div>
       <h4>회사정보</h4>
      <Outlet />
    </div>
  );
};

export default AboutLayout;