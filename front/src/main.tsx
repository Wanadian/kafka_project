import React from 'react'
import ReactDOM from 'react-dom/client'
import Home from './pages/home/home'
import { Container, MantineProvider } from '@mantine/core';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import Details from "./pages/details/details";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
        <BrowserRouter>
            <MantineProvider withGlobalStyles withNormalizeCSS>
                <HeaderComponent links={[
                    {"link": "/", "label": "Home"},
                    {"link": "/details", "label": "Details"}
                ]}/>
                <Container>
                    <Routes>
                        <Route path="/" element={<Home/>}/>
                        <Route path="/details" element={<Details/>}/>
                    </Routes>
                </Container>
                <FooterComponent/>
            </MantineProvider>
        </BrowserRouter>
    </React.StrictMode>,
)
