import React from 'react'
import ReactDOM from 'react-dom/client'
import { Container, MantineProvider } from '@mantine/core';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import Home from './pages/home/home'
import Details from "./pages/details/details";
import Team from "./pages/team/team";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
        <BrowserRouter>
            <MantineProvider withGlobalStyles withNormalizeCSS>
                <HeaderComponent links={[
                    {"link": "/", "label": "Home"},
                    {"link": "/details", "label": "Details"},
                    {"link": "/team", "label": "Team"}
                ]}/>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/details" element={<Details/>}/>
                    <Route path="/team" element={<Team/>}/>
                </Routes>
                <FooterComponent/>
            </MantineProvider>
        </BrowserRouter>
    </React.StrictMode>,
)
