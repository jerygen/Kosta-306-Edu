import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import Ex01_Count from "./components/Ex01_Count.jsx";
import { Provider } from "react-redux";
import todoCURD from "./redux/crud.js";

createRoot(document.getElementById("root")).render(
  <Provider store={todoCURD}>
    <App />
    {/* <Ex01_Count /> */}
  </Provider>,
);
