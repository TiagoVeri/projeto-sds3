import DashBoard from "pages/Dashboard";
import Home from "pages/Home";
import { BrowserRouter, Route, Switch } from "react-router-dom";

function Router() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/dashboard" exact>
          <DashBoard />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Router;
